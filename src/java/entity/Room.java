package entity;

public class Room {
    private int roomId;
    private String roomName;
    private int roomBed;
    private int cateId;
    private double roomPrice;
    private String roomImg;
    private double roomSize;
    private String roomView;
    private int roomMax;
    private int roomStar;
    private String roomDescrip;
    
    public Room() {
    }

    public Room(int roomId, String roomName, int roomBed, int cateId, double roomPrice, String roomImg, double roomSize, String roomView, int roomMax, int roomStar, String roomDescrip) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomBed = roomBed;
        this.cateId = cateId;
        this.roomPrice = roomPrice;
        this.roomImg = roomImg;
        this.roomSize = roomSize;
        this.roomView = roomView;
        this.roomMax = roomMax;
        this.roomStar = roomStar;
        this.roomDescrip = roomDescrip;
    }

    public String getRoomDescrip() {
        return roomDescrip;
    }

    public void setRoomDescrip(String roomDescrip) {
        this.roomDescrip = roomDescrip;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomBed() {
        return roomBed;
    }

    public void setRoomBed(int roomBed) {
        this.roomBed = roomBed;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public double getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(double roomSize) {
        this.roomSize = roomSize;
    }

    public String getRoomView() {
        return roomView;
    }

    public void setRoomView(String roomView) {
        this.roomView = roomView;
    }

    public int getRoomMax() {
        return roomMax;
    }

    public void setRoomMax(int roomMax) {
        this.roomMax = roomMax;
    }

    public int getRoomStar() {
        return roomStar;
    }

    public void setRoomStar(int roomStar) {
        this.roomStar = roomStar;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomImg() {
        return roomImg;
    }

    public void setRoomImg(String roomImg) {
        this.roomImg = roomImg;
    }
    
    @Override
    public String toString() {
        return "Room{" + "roomId=" + roomId + ", roomName=" + roomName + ", roomBed=" + roomBed + ", cateId=" + cateId +
                ", roomSize=" + roomSize + ", roomView=" + roomView + ", roomMax=" + roomMax + ", roomStar=" + roomStar + '}';
    }
    
    
}
