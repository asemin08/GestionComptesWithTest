package eu.esnup.gestioncomptetest.services;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Test Suite pour gestion Compte")
@SelectClasses({CarteServiceTest.class, CompteServiceTest.class})
public class SuiteTest {
}