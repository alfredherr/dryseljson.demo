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
package com.orchestral.automation.dryseljson.demo.helper;

import java.nio.file.Paths;

public class JsonFilePathHelper {
	private static String root;

	public static String getRoot() {
		JsonFilePathHelper.root = "src/test/resources/json/";
		return JsonFilePathHelper.root;
	}

	// paths for AppLauncher
	public static String getAppLauncherFolderPath() {
		return Paths.get(JsonFilePathHelper.getRoot(), "applauncher").toString();
	}

	public static String getAppLauncherUIFolderPath() {
		return Paths.get(JsonFilePathHelper.getAppLauncherFolderPath(), "ui").toString();
	}

	public static String getAppLauncherInputFolderPath() {
		return Paths.get(JsonFilePathHelper.getAppLauncherFolderPath(), "input").toString();
	}

	public static String getAppLauncherOutputFolderPath() {
		return Paths.get(JsonFilePathHelper.getAppLauncherFolderPath(), "output").toString();
	}

	// paths for Login
	public static String getLoginFolderPath() {
		return Paths.get(JsonFilePathHelper.getRoot(), "login").toString();
	}

	public static String getLoginUIFolderPath() {
		return Paths.get(JsonFilePathHelper.getLoginFolderPath(), "ui").toString();
	}

	public static String getLoginInputFolderPath() {
		return Paths.get(JsonFilePathHelper.getLoginFolderPath(), "input").toString();
	}

	public static String getLoginOutputFolderPath() {
		return Paths.get(JsonFilePathHelper.getLoginFolderPath(), "output").toString();
	}

	// paths for userInfo
	public static String getUserInfoFolderPath() {
		return Paths.get(JsonFilePathHelper.getRoot(), "userinfo").toString();
	}

	public static String getUserInfoUIFolderPath() {
		return Paths.get(JsonFilePathHelper.getUserInfoFolderPath(), "ui").toString();
	}

	public static String getUserInfoInputFolderPath() {
		return Paths.get(JsonFilePathHelper.getUserInfoFolderPath(), "input").toString();
	}

	public static String getUserInfoIOutputFolderPath() {
		return Paths.get(JsonFilePathHelper.getUserInfoFolderPath(), "output").toString();
	}

}
