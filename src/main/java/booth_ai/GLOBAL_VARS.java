/*
 * Copyright (C) 2018 xterminate
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package booth_ai;

/**
 *
 * @author xterminate
 */
public class GLOBAL_VARS {     
    
    public static String LBP_FACECASCADE = Settings.userPrefs.get("lbpcascade", null);
    public static String HAAR_SMILECASCADE = Settings.userPrefs.get("haarcascade", null);
    public static String OUTPUT_FILE = Settings.userPrefs.get("outpfile", null);
    public static String USBCPY_SCRIPT_PATH = Settings.userPrefs.get("usbcpy", null);
    public static String GMAIL_USERNAME = Settings.userPrefs.get("gmail_user", null);
    public static String GMAIL_PASSWORD = Settings.userPrefs.get("gmail_pass", null);
    public static String PRINT_DOCUMENT_PATH = "/home/xterminate/print/file.pdf";
    public static String FIREBASE_AUTH_FILE_PATH = "/home/xterminate/project/testing/selfiebooth-72-firebase-adminsdk-o5z5a-5efc1e7c43.json";
    public static String FIREBASE_URL = "https://selfiebooth-72.firebaseio.com";
    public static String FIREBASE_WEB_AUTH = "AIzaSyAEStqQ9YxR0XVdzP6dGVKc9TOorp0vP98";

}
