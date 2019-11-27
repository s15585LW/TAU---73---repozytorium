package WalenskiCorp;

import java.util.List;

public interface KajetInterface {

    public Kajet create(Kajet kajet);

    public List<Kajet> readAll();

    public Kajet read(Long id);

    public Kajet update(Kajet kajet);

    public void delete(Long id);

    public long getTimeNow();

}
