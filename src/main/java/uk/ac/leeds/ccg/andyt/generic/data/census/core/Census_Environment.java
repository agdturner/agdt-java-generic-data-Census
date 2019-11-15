/*
 * Copyright 2019 Centre for Computational Geography, University of Leeds.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.leeds.ccg.andyt.generic.data.census.core;

import java.io.File;
import java.io.IOException;
import uk.ac.leeds.ccg.andyt.generic.data.census.io.Census_Files;
import uk.ac.leeds.ccg.andyt.data.core.Data_Environment;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_Defaults;

/**
 *
 * @author geoagdt
 */
public class Census_Environment {

    public transient final Data_Environment de;
    public transient final Census_Files files;
            
    /**
     * 
     * @param e What {@link #de} is set to. 
     * @param dir Directory used to initialise {@link #files}. 
     * @throws java.io.IOException If dir cannot be set up as a data directory.
     */
    public Census_Environment(Data_Environment e, File dir) throws IOException {
        this.de = e;
        files = new Census_Files(dir);
    }

    public Census_Files getFiles() {
        return (Census_Files) files;
    }
}