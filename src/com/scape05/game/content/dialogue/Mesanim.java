package com.scape05.game.content.dialogue;

/**
 * Contains all the emotions the chathead can show in a dialogue.
 * @author Devenir
 */
public enum Mesanim {

	basic(new int[]{}),
	neutral(new int[]{}),
	happy(new int[]{}),
	sad(new int[]{}),
	angry(new int[]{}),
	laugh(new int[]{}),
	drunk(new int[]{}),
	shocked(new int[]{}),
	interested(new int[]{}),
	wondering(new int[]{}),
	worried(new int[]{}),
	very_sad(new int[]{}),
	shifty(new int[]{}),
	evil_stare(new int[]{}),
	evil_laugh(new int[]{}),
	singing(new int[]{}),
	single_word(new int[]{}),
	stare(new int[]{}),
	goblin(new int[]{}),
	skull(new int[]{}),
	easter_bunny(new int[]{}),
	tree(new int[]{});

	private final int[] emotion;

    Mesanim(int[] emotion) {
		this.emotion = emotion;
	}

	public int getEmotion(int lines) {
		return emotion[lines];
	}
}
