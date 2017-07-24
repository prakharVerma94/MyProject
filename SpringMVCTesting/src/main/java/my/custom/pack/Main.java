package my.custom.pack;

import java.util.ArrayList;
import java.util.List;

import my.custom.pack.MnemonicException.MnemonicChecksumException;
import my.custom.pack.MnemonicException.MnemonicLengthException;
import my.custom.pack.MnemonicException.MnemonicWordException;

public class Main {

	/*
	DeterministicSeed seed = wallet.getKeyChainSeed();
	println("Seed words are: " + Joiner.on(" ").join(seed.getMnemonicCode()));
	println("Seed birthday is: " + seed.getCreationTimeSeconds());

	String seedCode = "yard impulse luxury drive today throw farm pepper survey wreck glass federal";
	long creationtime = 1409478661L;
	DeterministicSeed seed = new DeterministicSeed(seedCode, null, "", creationtime);
	Wallet restoredWallet = Wallet.fromSeed(params, seed);
	// now sync the restored wallet as described below.
	*/	
	
	public static void main(String[] args) {
		
		MnemonicCode mm = null;
		try{
			mm = new MnemonicCode();
		}catch(Exception e){
			System.out.println("inside  exception"+e.getMessage());
		}

		ArrayList<String> inputWordArray = new ArrayList();
	
		inputWordArray.add("hi");
		inputWordArray.add("prakhar");
		inputWordArray.add("verma");
		
	/*	al.add("yard");
		al.add("impulse");
		al.add("luxury");
		al.add("drive");
		al.add("todays");
		al.add("throw");
		al.add("farm");
		al.add("pepper");
		al.add("survey");
		al.add("wreck");
		al.add("glass");
		al.add("federal");
		*/
		
		System.out.println("Input word is : "+inputWordArray);
		String phrase = "prakhar.verma@oodlestechnologies.com";
		byte[] seed = null;
		try {
			seed = mm.toSeed(inputWordArray,phrase);
			System.out.println("\n\nSeed of words into byte form :::::::::::  "+new String(seed));
			String mnemonicWord = "";
			List<String>  array = mm.toMnemonic(seed);
			for(String str: array){
				mnemonicWord += str + " ";
			}
			mnemonicWord.trim();
			System.out.println("\n\nMnenonic word is : "+mnemonicWord);
			System.out.println("Size   is : "+array.size());
			byte[] entropy = mm.toEntropy(array);
			System.out.println("nemonic word Via entropy    "+mm.toMnemonic(entropy));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
