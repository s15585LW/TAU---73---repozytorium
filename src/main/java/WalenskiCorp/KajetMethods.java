package WalenskiCorp;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class KajetMethods implements KajetInterface, TimeStampInterface {

    public static ArrayList<Kajet> kajetList = new ArrayList<>();

    private long time;
    private boolean readTimeEnabled = true;
    private boolean addTimeEnabled = true;
    private boolean updateTimeEnabled = true;

    public KajetMethods(){}   //konstr bezparametrowy

    // CREATE //
    @Override
    public Kajet create(Kajet createKajet) throws IllegalArgumentException {   //CREATE
        for (Kajet item:kajetList){
            if(createKajet.getId().equals(item.getId())){
                throw new IllegalArgumentException("ID już istnieje");
            }
        }
        if(addTimeEnabled){
            createKajet.setAddTime(getTimeNow());
        }
        //createKajet.setAddTime(getTimeNow());
        kajetList.add(createKajet);
        return createKajet;
    }

    // READ //
    //Wszystko
    @Override
    public ArrayList<Kajet> readAll(){
        for (Kajet item:kajetList){
            item.setReadTime(getTimeNow());
        }
        return kajetList;
    }

    //Jeden rekord
    @Override
    public Kajet read(Long id){
        for (Kajet item: kajetList){
            if(id.equals(item.getId())){
                if(readTimeEnabled){
                    item.setReadTime(getTimeNow());
                }
                return item;
            }
        }
        throw new NoSuchElementException("ID już istnieje");
    }

    // UPDATE //
    @Override
    public Kajet update(Kajet updateKajet){
        if(kajetList.contains(updateKajet)){
            kajetList.set(kajetList.indexOf(updateKajet), updateKajet);
            if(updateTimeEnabled){
                updateKajet.setUpdateTime(getTimeNow());
            }
            return updateKajet;
        }
        throw new NoSuchElementException("ID już istnieje");
    }

    @Override
    public void delete(Long id){
        Kajet kajetToDelete = read(id);
        kajetList.remove(kajetToDelete);
    }


    @Override
    public long getTimeNow() {
        return this.time;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    //Method for getting times for kajet by id

    public ArrayList<Long> getAllTimesForKajet(Long id){
        ArrayList<Long> allTime = new ArrayList<Long>();
        for(Kajet item: kajetList){
            if(id.equals(item.getId())){
                allTime.add(0, item.getAddTime());
                allTime.add(1, item.getReadTime());
                allTime.add(2, item.getUpdateTime());
                return allTime;
            }
        }
        throw new NoSuchFieldError();
    }

    public boolean setReadTimeEnabled() {
        return this.readTimeEnabled = true;
    }

    public boolean setReadTimeDisabled() {
        return this.readTimeEnabled = false;
    }

    public boolean setAddTimeEnabled() {
        return this.addTimeEnabled = true;
    }

    public boolean setAddTimeDisabled() {
        return this.addTimeEnabled= false;
    }

    public boolean setUpdateTimeEnabled() {
        return this.updateTimeEnabled = true;
    }

    public boolean setUpdateTimeDisabled() {
        return this.updateTimeEnabled = false;
    }
}
