package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Tabela {
    private List<Time> times;

    public Tabela(List<Time> times) {
        this.times = times;
    }

    public Time getLider() {
        if (times.isEmpty()) return null;

        Time[] lista_times = new Time[times.size()];

        PriorityQueue<Time> timesQueue = new PriorityQueue<Time>(new Comparador());

        timesQueue.addAll(times);
        for (int i = 0; i < times.size(); i++) {
            lista_times[i] = timesQueue.poll();
        }

        return lista_times[0];
    }

    public Time getLanterna() {
        if (times.isEmpty()) return null;
        Time[] lista_times = new Time[times.size()];

        PriorityQueue<Time> timesQueue = new PriorityQueue<Time>(new Comparador());

        timesQueue.addAll(times);
        for (int i = 0; i < times.size(); i++) {
            lista_times[i] = timesQueue.poll();
        }

        return lista_times[times.size() - 1];
    }



    public List<Time> getTimesRebaixados() {
        if (times.isEmpty()) return new ArrayList<>();
        return times.stream().sorted(Comparator.comparingInt(Time::getPontos).reversed())
                .skip(times.size() - 3)
                .collect(Collectors.toList());
    }
    public Time getTime(String nome) {
        return times.stream().filter(time -> time.getNome().equals(nome)).findFirst().orElse(null);
    }
}