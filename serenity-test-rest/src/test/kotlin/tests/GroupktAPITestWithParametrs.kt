package tests

import net.serenitybdd.junit.runners.SerenityParameterizedRunner
import net.thucydides.core.annotations.Steps
import org.junit.Test
import org.junit.runner.RunWith
import steps.CountriesSearchSteps
import net.thucydides.junit.annotations.TestData
import java.util.*


@RunWith(SerenityParameterizedRunner::class)
class CountriesSearchTestsWithParametrs(private var countryCode: String, private var expectedValue: String) {

    companion object {
        @JvmStatic
        @TestData
        fun testData(): Collection<Array<String>> =
                Arrays.asList(
                        arrayOf("RU", "Russian Federation"),
                        arrayOf("IN", "India")
                )
    }

    @Steps
    lateinit var countriesSearchSteps: CountriesSearchSteps

    @Test
    fun verifyThatWeCanFindCountryByCode() {
        countriesSearchSteps.searchCountryByCode(countryCode)
        countriesSearchSteps.searchIsExecutedSuccesfully()
        countriesSearchSteps.iShouldFindCountry(expectedValue)
    }

}