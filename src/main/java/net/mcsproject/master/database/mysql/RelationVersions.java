/*
 *     MCS - Minecraft Cloud System
 *     Copyright (C) 2016
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.mcsproject.master.database.mysql;

public enum RelationVersions {

    USER(new String[] {"1.0.0"});

	private String[] versions;

	RelationVersions(String[] versions) {
		this.versions = versions;
	}

    public String[] getAllUpdates(String version){
        int index = 0;
        for (int i = versions.length - 1; i >= 0; i-- ){
            if(version.equalsIgnoreCase(versions[i])){
                index = i + 1;
                break;
            }
        }
        int length = versions.length - index;
        String[] dest = new String[length];
        System.arraycopy(versions, index, dest, 0, length);
        return dest;
    }

    public String getLatestVersion(){
        return versions[versions.length - 1];
    }
}
