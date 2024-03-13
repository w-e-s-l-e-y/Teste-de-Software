package org.example;

import java.util.ArrayList;
import java.util.List;

public class TimeRepository {
    private List<Time> times;
    private int nextId;

    public TimeRepository() {
        this.times = new ArrayList<>();
        this.nextId = 1; // Inicializa o próximo ID como 1
    }

    public void save(Time time) {
        // Implementação para salvar um time no repositório
        time.setId(nextId++); // Atribui um novo ID ao time e incrementa o próximo ID
        times.add(time);
    }

    public Time findById(int id) {
        // Implementação para buscar um time pelo ID no repositório
        for (Time time : times) {
            if (time.getId() == id) {
                return time;
            }
        }
        return null; // Retorna null se o time não for encontrado
    }

    public List<Time> findAll() {
        // Implementação para buscar todos os times no repositório
        return new ArrayList<>(times); // Retorna uma cópia da lista de times
    }

    public void delete(int id) {
        // Implementação para excluir um time do repositório
        times.removeIf(time -> time.getId() == id);
    }
}