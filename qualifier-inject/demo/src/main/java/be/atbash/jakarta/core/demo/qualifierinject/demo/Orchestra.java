/*
 * Copyright 2022 Rudy De Busscher (Atbash)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package be.atbash.jakarta.core.demo.qualifierinject.demo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
public class Orchestra {

    private static final Logger LOGGER = Logger.getLogger(Orchestra.class.getName());

    //@Inject
    @MusicalInstrument(InstrumentType.PERCUSSION)
    private Instrument percussion;

    //@Inject
    @MusicalInstrument(InstrumentType.KEYBOARD)
    private Instrument keyboard;

    //@Inject
    @MusicalInstrument(InstrumentType.STRING)
    private Instrument string;

    @Inject  // No qualifier, so @Default is taken = Piano
    private Instrument solo;

    //@Inject
    @Any
    // Instance can be used when optional or multiple matches.
    private Instance<Instrument> instruments;

    public void string() {
        LOGGER.log(Level.INFO, "The string sound: {0}", string.sound());
    }

    public void percussion() {
        LOGGER.log(Level.INFO, "The percussion sound: {0}", percussion.sound());
    }

    public void keyboard() {
        LOGGER.log(Level.INFO, "The keyboard''s sound: {0}", keyboard.sound());
    }


    public void solo() {
        LOGGER.log(Level.INFO, "The solo sound: {0}", solo.sound());
    }

    public void allSound() {
        String sounds = this.instruments.stream().map(Instrument::sound).collect(Collectors.joining(", "));
        LOGGER.log(Level.INFO, "All instruments sounds are: {0}", sounds);
    }
}
