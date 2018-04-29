package com.oldscape.client;

public class SoundTaskDataProvider implements ISoundTaskDataProvider {

   public AbstractSoundSystem getNewSoundSystem() {
      return new SourceDataSoundSystem();
   }

}
