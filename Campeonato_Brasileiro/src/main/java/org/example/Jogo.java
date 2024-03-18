package org.example;

import java.util.Date;

public class Jogo {
   private int id;
   private String timeCasa;
   private String timeVisitante;
   private int golsCasa;
   private int golsVisitante;
   private Date data;

   public Jogo(int id, String timeCasa, String timeVisitante, int golsCasa, int golsVisitante, Date data) {
      this.id = id;
      this.timeCasa = timeCasa;
      this.timeVisitante = timeVisitante;
      this.golsCasa = golsCasa;
      this.golsVisitante = golsVisitante;
      if (data != null) {
         this.data = data;
      } else {
         // Se a data for nula, defina a data padrão como 01/01/2024
         this.data = new Date(123, 0, 1); // Ano 2024, Mês 0 (janeiro), Dia 1
      }
   }

   // Getters e setters
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getTimeCasa() {
      return timeCasa;
   }

   public void setTimeCasa(String timeCasa) {
      this.timeCasa = timeCasa;
   }

   public String getTimeVisitante() {
      return timeVisitante;
   }

   public void setTimeVisitante(String timeVisitante) {
      this.timeVisitante = timeVisitante;
   }

   public int getGolsCasa() {
      return golsCasa;
   }

   public void setGolsCasa(int golsCasa) {
      this.golsCasa = golsCasa;
   }

   public int getGolsVisitante() {
      return golsVisitante;
   }

   public void setGolsVisitante(int golsVisitante) {
      this.golsVisitante = golsVisitante;
   }

   public Date getData() {
      return data;
   }

   public void setData(Date data) {
      this.data = data;
   }

   @Override
   public String toString() {
      return "Jogo{" +
              "id=" + id +
              ", timeCasa='" + timeCasa + '\'' +
              ", timeVisitante='" + timeVisitante + '\'' +
              ", golsCasa=" + golsCasa +
              ", golsVisitante=" + golsVisitante +
              ", data=" + data +
              '}';
   }
}
