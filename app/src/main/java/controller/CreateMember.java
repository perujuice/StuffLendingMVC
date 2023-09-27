package controller;

public class CreateMember {
    
    public model.Member createMember(String name, String email, int phoneNumber) {
        model.Member member = new model.Member(name, email, phoneNumber);
        //dataManager.addMember(model.Member);
    }
}
