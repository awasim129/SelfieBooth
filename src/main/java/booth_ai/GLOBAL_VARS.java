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
}
