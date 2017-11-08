/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2017).
 * Author: Kuldeep Sinh Chauhan (@KuldeepSinhC)
 * emails: kuldeeps@orionhealth.com, chauhan.kuldeep.sinh@gmail.com
 *
 * This file is provided to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an  "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,  either express or implied.  See the License for the specific language governing    
 * permissions and limitations under the License.
 */
package com.orchestral.automation.dryseljson.demo.stepdefs;

import java.nio.file.Paths;

import com.orchestral.automation.dryselcore.eventlib.ElementNotEnabledException;
import com.orchestral.automation.dryseljson.demo.helper.JsonFilePathHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {

	private final String jsonFileForLoginPageUi;
	private final String jsonFileForUserInfoPageUi;
	private final String jsonFileForInput;
	private final String jsonFileForOutput;

	public Login() {
		this.jsonFileForLoginPageUi = Paths.get(JsonFilePathHelper.getLoginUIFolderPath(), "loginPage_ui.json")
				.toString();
		this.jsonFileForInput = Paths.get(JsonFilePathHelper.getLoginInputFolderPath(), "loginPage_in.json")
				.toString();
		this.jsonFileForOutput = Paths.get(JsonFilePathHelper.getLoginOutputFolderPath(), "loginPage_out.json")
				.toString();
		this.jsonFileForUserInfoPageUi = Paths.get(JsonFilePathHelper.getUserInfoUIFolderPath(), "userInfoPage_ui.json")
				.toString();
	}

	@Given("^Joe is an authorized user$")
	public void openWeb() throws Throwable {
		new AppLaunch().openWebApp();
	}

	@When("^Joe enters correct user-name and password$")
	public void loginAsJoe() {
		try {
			new JsonStepDefHelper().getTestExecutor().executeInputScript(this.jsonFileForLoginPageUi,
					this.jsonFileForInput);
		} catch (final ElementNotEnabledException e) {
			e.printStackTrace();
		}
	}

	@Then("^User information page should be displayed$")
	public void user_information_page_should_be_displayed() {
		try {
			new JsonStepDefHelper().getTestExecutor().executeOutputScript(this.jsonFileForUserInfoPageUi,
					this.jsonFileForOutput);
		} catch (final ElementNotEnabledException e) {
			e.printStackTrace();
		}
	}
}
