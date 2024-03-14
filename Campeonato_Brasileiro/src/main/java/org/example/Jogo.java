package org.example;

public class Jogo {
   private int id;
   private Time timeCasa;
   private Time timeVisitante;
   private int resultadoCasa;
   private int resultadoVisitante;

   public Jogo(Time timeCasa, Time timeVisitante) {
      this.timeCasa = timeCasa;
      this.timeVisitante = timeVisitante;
   }

   public void setResultado(String resultado) {
      String[] partes = resultado.split("x");
      this.resultadoCasa = Integer.parseInt(partes[0]);
      this.resultadoVisitante = Integer.parseInt(partes[1]);
   }

   public String getResultado() {
      return resultadoCasa + "x" + resultadoVisitante;
   }
}



