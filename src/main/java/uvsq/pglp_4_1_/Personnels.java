package uvsq.pglp_4_1_;

import java.util.ArrayList;

public final class Personnels implements GroupPersonnels {
	
	public  String Nom;
	public  String Prenom;
	public  String fonction;
	public  java.time.LocalDate dateNaissance;
	public  ArrayList<Integer> numerosDeTel;
	
	Personnels(Builder bu)
	{
		Nom=bu.Nom;
		Prenom=bu.Prenom;
		fonction=bu.fonction;
		dateNaissance=bu.dateNaissance;
		numerosDeTel=bu.numerosDeTel;
	}
	public static class Builder {
		
		private final String Nom;
		private final String Prenom;
		private final java.time.LocalDate dateNaissance;
		
		private  String fonction="Non Connue";		
		private  ArrayList<Integer> numerosDeTel=null;
		
		
		public Builder(String Name,String Surname,java.time.LocalDate Birth)
		{
			this.dateNaissance=Birth;
			this.Nom=Name;
			this.Prenom=Surname;
		}
		
		public Builder AddTel(int numero)
		{
			this.numerosDeTel.add(numero);
			return this;
		}
		
		public Personnels build()
		{
			return new Personnels(this);
		}
	}
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Nom:" + Nom );
		
	}
	

}
