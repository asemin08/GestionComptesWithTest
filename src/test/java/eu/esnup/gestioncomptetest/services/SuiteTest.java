package eu.esnup.gestioncomptetest.services;

import org.junit.platform.suite.api.*;

/**
 * The type Suite test.
 */
@Suite
@SuiteDisplayName("Test Suite pour gestion Compte")
@SelectClasses({CarteServiceTest.class, CompteServiceTest.class, BanquierServiceTest.class, ClientServiceTest.class})
public class SuiteTest {
}