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

import java.io.IOException;

/**
 *
 * @author xterminate
 */
public class FBTEST {
    public static void main(String[] args) throws IOException, Exception {
        Firebase fb = new Firebase();
        fb.connect();
        String token = fb.auth("awasim128@gmail.com", "Humidity456");
        String email = fb.getAccountInfo(token);
        System.out.println("Email is:" + email);
    }
}
