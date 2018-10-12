package com.topjal.quiz.cucumber.stepdefs;

import com.topjal.quiz.TopjalApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = TopjalApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
