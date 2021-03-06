package com.acuity.api.rs.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Eclipseop.
 * Date: 6/12/2017.
 */
public class Prayers {

	private static final Logger logger = LoggerFactory.getLogger(Prayers.class);

	public static final int VARP_INDEX = 83;

	public static Stream<Prayer> stream() {
		return Arrays.stream(Prayer.values());
	}

	public static Stream<Prayer> streamActive() {
		return stream().filter(Prayer::isActive);
	}

	public static int currentPrayerVarp() {
		return Varps.get(VARP_INDEX, 0);
	}

	public static int getActiveCount() {
		return Integer.bitCount(currentPrayerVarp());
	}

	public static boolean isAnyActivated() {
		return currentPrayerVarp() != 0;
	}

	public static boolean isAllDeactivated() {
		return !isAnyActivated();
	}

	public static Optional<Prayer> getPrayerByOverheadID(int overheadID){
		if (overheadID == -1) return Optional.empty();
		for (Prayer prayer : Prayer.values()) {
			if (prayer.getOverheadID() == overheadID)
				return Optional.of(prayer);
		}
		return Optional.empty();
	}


	public enum Prayer {
		THICK_SKIN(1, 0x1),
		BURST_OF_STRENGTH(4, 0x2),
		CLARITY_OF_THOUGHT(7, 0x4),
		ROCK_SKIN(10, 0x8),
		SUPERHUMAN_STRENGTH(13, 0x10),
		IMPROVED_REFLEXES(16, 0x20),
		RAPID_RESTORE(19, 0x40),
		RAPID_HEAL(22, 0x80),
		PROTECT_ITEM(25, 0x100),
		STEEL_SKIN(28, 0x200),
		ULTIMATE_STRENGTH(31, 0x400),
		INCREDIBLE_REFLEXES(34, 0x800),
		PROTECT_FROM_MAGIC(37, 0x1000, 2),
		PROTECT_FROM_MISSILES(40, 0x2000, 1),
		PROTECT_FROM_MELEE(43, 0x4000, 0),
		RETRIBUTION(46, 0x8000, 3),
		REDEMPTION(49, 0x10000, 5),
		SMITE(52, 0x20000, 4),
		SHARP_EYE(8, 0x40000),
		MYSTIC_WILL(9, 0x80000),
		HAWK_EYE(26, 0x100000),
		MYSTIC_LORE(27, 0x200000),
		EAGLE_EYE(44, 0x400000),
		MYSTIC_MIGHT(45, 0x800000),
		CHIVALRY(60, 0x2000000),
		PIETY(70, 0x4000000),
		RIGOUR(74, 0x1000000),
		AUGURY(77, 0x8000000),
		PRESERVE(55, 0x10000000);

		private final int levelRequirement;
		private final int bits;
		private final int overheadID;

		Prayer(int levelRequirement, int bits) {
			this(levelRequirement, bits, -1);
		}

		Prayer(int levelRequirement, int bits, int overheadID) {
			this.levelRequirement = levelRequirement;
			this.bits = bits;
			this.overheadID = overheadID;
		}

		public int getBits() {
			return bits;
		}

		public int getLevelRequirement() {
			return levelRequirement;
		}

		public int getOverheadID() {
			return overheadID;
		}

		public boolean isActive() {
			return (Prayers.currentPrayerVarp() & bits) != 0;
		}

		@Override
		public String toString() {
			final String name = name();
			return name.charAt(0) + name.substring(1).toLowerCase().replace("_", " ");
		}
	}
}
