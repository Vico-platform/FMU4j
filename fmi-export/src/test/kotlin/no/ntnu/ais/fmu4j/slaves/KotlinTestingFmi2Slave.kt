package no.ntnu.ais.fmu4j.slaves

import no.ntnu.ais.fmu4j.export.fmi2.Fmi2Slave
import no.ntnu.ais.fmu4j.export.fmi2.ScalarVariable
import no.ntnu.ais.fmu4j.modeldescription.fmi2.Fmi2Causality

open class KotlinTestingFmi2Slave(
    args: Map<String, Any>
) : Fmi2Slave(args) {

    @ScalarVariable(causality = Fmi2Causality.local)
    var real = 123.0

    @ScalarVariable(causality = Fmi2Causality.output)
    lateinit var str: String

    @ScalarVariable(causality = Fmi2Causality.input)
    var start: Double = 5.0

    private val container = TestContainer()

    override fun registerVariables() {
        register(real("subModel.out") { 99.0 })
        register(real("container.value") { container.value })
        register(integer("container.container.value") { container.container.value })
    }

    override fun setupExperiment(startTime: Double, stopTime: Double, tolerance: Double) {
        str = startTime.toString()
    }

    override fun doStep(currentTime: Double, dt: Double) {}

}

open class KotlinTestingExtendingFmi2Slave(
    args: Map<String, Any>
) : KotlinTestingFmi2Slave(args) {

    override fun doStep(currentTime: Double, dt: Double) {}

}

class TestContainer {

    val value: Double = 5.0
    val container = TestContainer2()

}

class TestContainer2 {

    val value: Int = 1

}
