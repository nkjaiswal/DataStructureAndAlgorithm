import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


enum CarSkills {
    TYRE, LIGHT, BREAK, GEAR, WHEEL, DIGITAL_AUDIO
}


//This is car model class
class Car{
    String type;
    List<CarSkills> validRepaireSkills;
    Car(String type, List<CarSkills> validRepaireSkills) {
        this.type = type;
        this.validRepaireSkills = validRepaireSkills;
    }
}



class CarTechnician {
    Integer id;

    private String technicianName;
    private List<String> carsTypes;
    private List<CarSkills> haveSkills;
    Integer maxRepair;
    CarTechnician(Integer id, String technicianName, List<String> cars, List<CarSkills> haveSkills, Integer maxRepair) {
        this.id = id;
        this.technicianName = technicianName;
        this.carsTypes = cars;
        this.haveSkills = haveSkills;
        this.maxRepair = maxRepair;
    }

    boolean canTechnicianRepair(String carModel, CarSkills skill){
        if(carsTypes.contains(carModel) && haveSkills.contains(skill))
            return true;
        else
            return false;
    }
    @Override
    public String toString() {
        return "CarTechnician{" +
                "id=" + id +
                ", technicianName='" + technicianName + '\'' +
                ", carsTypes=" + carsTypes +
                ", haveSkills=" + haveSkills +
                ", maxRepair=" + maxRepair +
                '}';
    }
}

//This is a Repair detail which contain, model, carTechnician, date, and skill
class RepaireRegisterRow {
    private CarTechnician carTechnician;
    private String carModel;
    private Date date;
    private CarSkills carSkills;

    RepaireRegisterRow(CarTechnician carTechnician, String carModel, Date date, CarSkills carSkills) {
        this.carTechnician = carTechnician;
        this.carModel = carModel;
        this.date = date;
        this.carSkills = carSkills;
    }

    @Override
    public String toString() {
        return "RepaireRegisterRow{" +
                "carTechnician=" + carTechnician +
                ", carModel='" + carModel + '\'' +
                ", date=" + date +
                ", carSkills=" + carSkills +
                '}';
    }

}

class CounterRegister {
    Integer technicianId;
    private Date date;
    CounterRegister(Integer technicianId, Date date) {
        this.technicianId = technicianId;
        this.date = date;
    }


    @Override
    public String toString() {
        return "CounterRegister{" +
                "technicianId=" + technicianId +
                ", date=" + date +
                '}';
    }
}



public class Solution {
    public static void main(String[] args){
        try{
            //Test cases
            testNoTechnicianAvailable();
            testAllSlotFullForTechnician();
            testFindFreeFitTechnician();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //This test will show that if one carTechnician is busy, find other fit carTechnician
    private static void testFindFreeFitTechnician() {
        CarRepaireShopInventory inv1 = initializeInventoryManagement();
        findFreeTechnician(inv1);
        findFreeTechnician(inv1);
        System.out.println(inv1.repairCar("MODEL3", CarSkills.TYRE, new Date("2018/12/01")));
    }

    private static void findFreeTechnician(CarRepaireShopInventory inv1) {
        System.out.println(inv1.repairCar("MODEL3", CarSkills.LIGHT, new Date("2018/12/01")));
        System.out.println(inv1.repairCar("MODEL3", CarSkills.LIGHT, new Date("2018/12/01")));
        System.out.println(inv1.repairCar("MODEL3", CarSkills.LIGHT, new Date("2018/12/01")));
        System.out.println(inv1.repairCar("MODEL3", CarSkills.LIGHT, new Date("2018/12/01")));
        System.out.println(inv1.repairCar("MODEL3", CarSkills.LIGHT, new Date("2018/12/01")));
    }

    //This test show that carTechnician whole day is busy and no other carTechnician is fit of this repair
    private static void testAllSlotFullForTechnician() {
        CarRepaireShopInventory inv1 = initializeInventoryManagement();
        AllSlotFullForTechnician(inv1);
        AllSlotFullForTechnician(inv1);
        System.out.println(inv1.repairCar("MODEL1", CarSkills.LIGHT, new Date("2018/12/01")));
    }

    private static void AllSlotFullForTechnician(CarRepaireShopInventory inv1) {
        System.out.println(inv1.repairCar("MODEL1", CarSkills.LIGHT, new Date("2018/12/01")));
        System.out.println(inv1.repairCar("MODEL1", CarSkills.LIGHT, new Date("2018/12/01")));
        System.out.println(inv1.repairCar("MODEL1", CarSkills.LIGHT, new Date("2018/12/01")));
        System.out.println(inv1.repairCar("MODEL1", CarSkills.LIGHT, new Date("2018/12/01")));
        System.out.println(inv1.repairCar("MODEL1", CarSkills.LIGHT, new Date("2018/12/01")));
    }

    //This test will show that no technical are present for this repair
    private static void testNoTechnicianAvailable() {
        CarRepaireShopInventory inv1 = initializeInventoryManagement();
        System.out.println(inv1.repairCar("MODEL6", CarSkills.LIGHT, new Date("2018/12/01")));
    }

    //Basic Inventory setup, similar to @Before test case
    private static CarRepaireShopInventory initializeInventoryManagement(){
        CarRepaireShopInventory carRepaireShopInventory = new CarRepaireShopInventory();

        CarTechnician t1 = new CarTechnician(1, "Avinash", Arrays.asList("MODEL1", "MODEL2", "MODEL3"), Arrays.asList(CarSkills.LIGHT, CarSkills.BREAK, CarSkills.GEAR), 10);
        CarTechnician t2 = new CarTechnician(2, "TestTechnician", Arrays.asList("MODEL3", "MODEL4", "MODEL5"), Arrays.asList(CarSkills.WHEEL, CarSkills.DIGITAL_AUDIO, CarSkills.TYRE), 10);
        CarTechnician t3 = new CarTechnician(3, "Vinodini", Arrays.asList("MODEL1", "MODEL5", "MODEL6"), Arrays.asList(CarSkills.WHEEL, CarSkills.DIGITAL_AUDIO, CarSkills.TYRE), 10);
        carRepaireShopInventory.addTechnicianToInventory(t1);
        carRepaireShopInventory.addTechnicianToInventory(t2);
        carRepaireShopInventory.addTechnicianToInventory(t3);

        Car c1 = new Car("MODEL1", Arrays.asList(CarSkills.LIGHT, CarSkills.TYRE, CarSkills.BREAK));
        Car c2 = new Car("MODEL2", Arrays.asList(CarSkills.LIGHT, CarSkills.BREAK, CarSkills.GEAR, CarSkills.TYRE   ));
        Car c3 = new Car("MODEL3", Arrays.asList(CarSkills.BREAK, CarSkills.GEAR, CarSkills.WHEEL, CarSkills.LIGHT, CarSkills.TYRE));
        Car c4 = new Car("MODEL4", Arrays.asList(CarSkills.GEAR, CarSkills.WHEEL, CarSkills.DIGITAL_AUDIO));
        Car c5 = new Car("MODEL5", Arrays.asList(CarSkills.WHEEL, CarSkills.DIGITAL_AUDIO, CarSkills.TYRE));
        Car c6 = new Car("MODEL6", Arrays.asList(CarSkills.DIGITAL_AUDIO, CarSkills.TYRE, CarSkills.LIGHT));

        carRepaireShopInventory.addCarsWhichCanThisInventoryServices(c1);
        carRepaireShopInventory.addCarsWhichCanThisInventoryServices(c2);
        carRepaireShopInventory.addCarsWhichCanThisInventoryServices(c3);
        carRepaireShopInventory.addCarsWhichCanThisInventoryServices(c4);
        carRepaireShopInventory.addCarsWhichCanThisInventoryServices(c5);
        carRepaireShopInventory.addCarsWhichCanThisInventoryServices(c6);
        return carRepaireShopInventory;
    }
}

//Main Inventory class which take care of all the operation
class CarRepaireShopInventory {
    private Map<Integer, CarTechnician> technicians;
    private Map<String, Car> serviceableCars; //Cars model which can be serviced by this Service Center
    private Map<String, Integer> repairCounterRegister;
    private List<RepaireRegisterRow> repairDetails;
    CarRepaireShopInventory(){
        technicians = new HashMap<>();
        serviceableCars = new HashMap<>();
        repairCounterRegister = new HashMap<>();
        repairDetails = new ArrayList<>();
    }

    void addTechnicianToInventory(CarTechnician t){
        if(!technicians.containsKey(t.id)){
            technicians.put(t.id, t);
        }
    }

    void addCarsWhichCanThisInventoryServices(Car c){
        if(!serviceableCars.containsKey(c.type)){
            serviceableCars.put(c.type, c);
        }
    }

    private CarTechnician getTechnician(Integer id){
        return technicians.get(id);
    }

    RepaireRegisterRow repairCar(String model, CarSkills skill, Date date){
        if(!serviceableCars.get(model).validRepaireSkills.contains(skill)){
            throw new RuntimeException("Not A Valid skill for this car");
        }
        for(Map.Entry e : technicians.entrySet()){
            Integer techId = (Integer) e.getKey();
            CarTechnician carTechnician = (CarTechnician) e.getValue();
            if(carTechnician.canTechnicianRepair(model, skill) && checkAvilability(new CounterRegister(techId, date))){
                return assgnTask(model, skill, date, carTechnician);
            }
        }
        throw new RuntimeException("All Technician Are Busy");
    }

    private RepaireRegisterRow assgnTask(String model, CarSkills skill, Date date, CarTechnician carTechnician){
        RepaireRegisterRow repairDetail = new RepaireRegisterRow(carTechnician, model, date, skill);
        repairDetails.add(repairDetail);
        CounterRegister counterRegister = new CounterRegister(carTechnician.id, date);
        if(repairCounterRegister.containsKey(counterRegister.toString())){
            repairCounterRegister.put(counterRegister.toString(), repairCounterRegister.get(counterRegister.toString())+1);
        }else{
            repairCounterRegister.put(counterRegister.toString(), 1);
        }
        return repairDetail;
    }

    private boolean checkAvilability(CounterRegister counterRegister) {
        return !repairCounterRegister.containsKey(counterRegister.toString()) || repairCounterRegister.get(counterRegister.toString()) < getTechnician(counterRegister.technicianId).maxRepair;
    }
}

