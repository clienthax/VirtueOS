package com.oldscape.client.reference;

public class SoundTaskDataProvider implements ISoundTaskDataProvider {

    public AbstractSoundSystem getNewSoundSystem() {
        return new SourceDataSoundSystem();
    }

}
