package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Tabela {
    private List<Time> times;

    public Tabela(List<Time> times) {
        this.times = times;
    }

    public Time getLider() {
        if (times.isEmpty()) return null;
        return times.stream().max(Comparator.comparingInt(Time::getPontos)).orElse(null);
    }

    public Time getLanterna() {
        if (times.isEmpty()) return null;
        return times.stream()
                .sorted(Comparator.comparingInt(Time::getPontos)
                        .thenComparingInt(Time::getSaldoDeGols))
                .findFirst()
                .orElse(null);
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