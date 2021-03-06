package no.ntnu.ais.fmu4j.slaves

import no.ntnu.ais.fmu4j.export.BulkRead
import no.ntnu.ais.fmu4j.export.fmi2.Fmi2Slave
import no.ntnu.ais.fmu4j.export.fmi2.ScalarVariable

class KotlinTestFmi2Slave(
    args: Map<String, Any>
) : Fmi2Slave(args) {

    private val data = Data()

    @ScalarVariable
    private var speed: Double = 10.0

    @ScalarVariable
    private var getAllInvoked: Boolean = false

    override fun registerVariables() {
        register(real("data.x") { data.x })
    }

    override fun doStep(currentTime: Double, dt: Double) {
        speed = -1.0
    }

    override fun getAll(intVr: LongArray, realVr: LongArray, boolVr: LongArray, strVr: LongArray): BulkRead {
        return super.getAll(intVr, realVr, boolVr, strVr).also {
            getAllInvoked = true
        }
    }

    data class Data(
        val x: Double = 0.0
    )

}

