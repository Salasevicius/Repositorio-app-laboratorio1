package com.example.laboratorio30

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
internal class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }



    @Test
    fun mainActivity_ComparadorTexto() {


        //Para ingresar las cadenas de caracteres
        Espresso.onView(ViewMatchers.withId(R.id.editText1)).perform(ViewActions.typeText(
            "123"))
        Espresso.onView(ViewMatchers.withId(R.id.editText2)).perform(ViewActions.typeText(
            "123"))

        // Para hacer click en el botón
        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click())


        // Para verificar el resultado en el TextView
        Espresso.onView(ViewMatchers.withId(R.id.textViewResultado))
            .check(ViewAssertions.matches(ViewMatchers.withText("Las cadenas de caracteres ingresadas son iguales")))



    }
}