package edu.ib;

import java.time.LocalTime;

//każda klasa która będzie chciała się dowiedzieć jaka
// jest godzina, może to zrobic za pomocą metody update

public interface Observer {
    void update(LocalTime localTime);
}
