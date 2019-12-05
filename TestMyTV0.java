public class TestMyTV0{
    static void print_tv(MyTV0 t){
        if(t.isOn()) System.out.println("CH:" + t.getChannel() + " VOL:" + t.getVolume());
        else System.out.println("TV_OFF");
    }
    public static void main(String args[]){
        MyTV2 t = new MyTV2();
        
        t.setChannel(100);
        t.setVolume(0);
        print_tv(t);
        
        t.turnOnOff();
        t.raiseChannel();
        t.raiseVolume();
        print_tv(t);
        
        t.setChannel(10);
        t.setVolume(100);
        t.lowerChannel();
        t.lowerVolume();
        print_tv(t);
        
        t.turnOnOff();
        t.lowerChannel();
        t.lowerVolume();
        print_tv(t);
        
        t.turnOnOff();
        t.setChannel(50);
        print_tv(t);
        t.gotoPrevChannel();
        print_tv(t);
        t.gotoPrevChannel();
        print_tv(t);
        t.lowerChannel();
        t.lowerChannel();
        print_tv(t);
        t.gotoPrevChannel();
        print_tv(t);
        t.gotoPrevChannel();
        print_tv(t);
    }
}

class MyTV0{
    private boolean isPowerOn;
    private int channel;
    private int volume;
    
    public static final int MAX_CHANNEL = 100;
    public static final int MIN_CHANNEL = 1;
    public static final int MAX_VOLUME = 100;
    public static final int MIN_VOLUME = 1;
    
    MyTV0(){
        isPowerOn = false;
        channel = MIN_CHANNEL;
        volume = MIN_VOLUME;
    }
    
    public boolean isOn() { return isPowerOn; }
    public void turnOn() { isPowerOn = true; }
    public void turnOff() { isPowerOn = false; }
    
    public void setChannel(int ch){
        if(isOn() && ch>=MIN_CHANNEL && ch<=MAX_CHANNEL)channel = ch;
    }
    
    public void setVolume(int vol){
        if(isOn() && vol>=MIN_VOLUME && vol<=MAX_VOLUME) volume = vol;
    }
    
    public int getChannel() { return channel; }
    public int getVolume() { return volume; }
}

class MyTV1 extends MyTV0{
    public void turnOnOff(){
        if(isOn()) turnOff();
        else turnOn();
    }
    
    public void lowerChannel() { setChannel(getChannel()-1); }
    public void raiseChannel() { setChannel(getChannel()+1); }
    public void lowerVolume() { setVolume(getVolume()-1); }
    public void raiseVolume() { setVolume(getVolume()+1); }
}

class MyTV2 extends MyTV1{
    private int previousChannel = -1;
    private int channel = MIN_CHANNEL;
    
    public void setChannel(int ch){
        if(isOn() && ch>=MIN_CHANNEL && ch<=MAX_CHANNEL){
            previousChannel = getChannel();
            channel = ch;
        }
    }
    
    public int getChannel(){
        return channel;
    }
    
    public boolean gotoPrevChannel(){
        if (previousChannel>=MIN_CHANNEL){
            setChannel(previousChannel);
            return true;
        }else return false;
    }
}