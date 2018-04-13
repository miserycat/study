package bean;

import java.util.Optional;

/**
 * Created by shengchao wu on 3/2/2018.
 */
public class NewMan {
    public NewMan() {
    }



    public NewMan(Optional<Goddess> goddessOpt) {
        this.goddessOpt = goddessOpt;
    }

    private Optional<Goddess> goddessOpt = Optional.empty();

    public Optional<Goddess> getGoddessOpt() {
        return goddessOpt;
    }

    public void setGoddessOpt(Optional<Goddess> goddessOpt) {
        this.goddessOpt = goddessOpt;
    }
}
