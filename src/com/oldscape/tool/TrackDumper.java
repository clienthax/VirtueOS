package com.oldscape.tool;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import com.oldscape.tool.cache.Cache;
import com.oldscape.tool.cache.Constants;
import com.oldscape.tool.cache.FileStore;
import com.oldscape.tool.cache.track.Track;
import com.oldscape.tool.cache.track.Tracks;

public final class TrackDumper {

	public static void main(String[] args) throws Exception {
		File track1Dir = new File(Constants.TRACK1_PATH);

		if (!track1Dir.exists()) {
			track1Dir.mkdirs();
		}

		File track2Dir = new File(Constants.TRACK2_PATH);

		if (!track2Dir.exists()) {
			track2Dir.mkdirs();
		}

		try (Cache cache = new Cache(FileStore.open(Constants.CACHE_PATH))) {
			@SuppressWarnings("unused")
			Tracks list = new Tracks();
			Tracks.initialize(cache);

			for (int i = 0; i < Tracks.getTrack1Count(); i++) {
				Track track1 = Tracks.getTrack1(i);

				if (track1 == null) {
					continue;
				}

				try (DataOutputStream dos = new DataOutputStream(
						new FileOutputStream(new File(track1Dir, i + ".midi")))) {
					dos.write(track1.getDecoded());
				}

				double progress = (double) (i + 1) / Tracks.getTrack1Count() * 100;
				System.out.printf("dumping track1 %d out of %d %.2f%s\n", (i + 1), Tracks.getTrack1Count(), progress,
						"%");
			}

			for (int i = 0; i < Tracks.getTrack2Count(); i++) {
				Track track2 = Tracks.getTrack2(i);

				if (track2 == null) {
					continue;
				}

				try (DataOutputStream dos = new DataOutputStream(
						new FileOutputStream(new File(track2Dir, i + ".midi")))) {
					dos.write(track2.getDecoded());
				}

				double progress = (double) (i + 1) / Tracks.getTrack2Count() * 100;
				System.out.printf("dumping track2 %d out of %d %.2f%s\n", (i + 1), Tracks.getTrack2Count(), progress,
						"%");
			}
		}
	}

}
