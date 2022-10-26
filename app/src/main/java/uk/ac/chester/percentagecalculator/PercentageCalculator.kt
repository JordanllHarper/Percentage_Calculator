package uk.ac.chester.percentagecalculator

class PercentageCalculator {

    private var prevValCalc = 0.0

    private fun Double.round(decPlaces: Int) : Double {
        var finalNumStr = ""
        var afterDecStr = ""
        var counter = 0
        var count = false

        for (num in this.toString()) {
            if (num == '.') {
                count = true
            }

            if (count) {
                afterDecStr += num
                counter++

                if (counter > decPlaces) {
                    break
                }

            } else {
                finalNumStr+= num
            }


        }

        if (decPlaces > afterDecStr.length) {
            val difference = decPlaces - afterDecStr.length
            for (num in 0..difference) {
                afterDecStr+= "0"
            }
        }

        finalNumStr += afterDecStr

        return finalNumStr.toDouble()

    }


    fun findValueOf(per: Double, x: Double): Double {
        prevValCalc = (per / 100) * x
        return prevValCalc.round(2)

    }

    fun findPercentAndAddOrg(per: Double, x: Double): Double {
        prevValCalc = x + findValueOf(per, x)
        return prevValCalc.round(2)
    }


    fun findPercentageIncrease(smallerValue: Double, largerValue: Double): Double {
        val difference = largerValue - smallerValue
        prevValCalc = (difference / smallerValue) * 100
        return prevValCalc.round(2)

    }


    fun findPercentageDecrease(smallerValue: Double, largerValue: Double): Double {
        val difference = largerValue - smallerValue
        prevValCalc = (difference / largerValue) * 100
        return prevValCalc.round(2)
    }
}
