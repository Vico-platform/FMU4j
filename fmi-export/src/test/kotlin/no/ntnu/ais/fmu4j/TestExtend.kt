package no.ntnu.ais.fmu4j

import no.ntnu.ais.fmu4j.slaves.SimpleSlave
import no.ntnu.ais.fmu4j.slaves.SimpleSlaveChild
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TestExtend {

    @Test
    fun test() {

        val slave = SimpleSlave(mapOf("instanceName" to "instance"))
        Assertions.assertDoesNotThrow {
            slave.__define__()
        }

        val slaveChild = SimpleSlaveChild(mapOf("instanceName" to "instance"))
        Assertions.assertDoesNotThrow {
            slaveChild.__define__()
        }

    }

}
