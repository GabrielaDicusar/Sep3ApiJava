package com.server;

import com.example.sep3apijava.mediator.model.User;
import com.example.sep3apijava.mediator.RegisterUserDB.RegisterUserDao;
import com.example.sep3apijava.mediator.RegisterUserDB.RegisterUserDaoImpl;
import com.sdj3.protobuf.UserGrpc;
import com.sdj3.protobuf.UserOuterClass;
import io.grpc.stub.StreamObserver;

public class UserService extends UserGrpc.UserImplBase {
    RegisterUserDao regUser= new RegisterUserDaoImpl();

    @Override
    public void addUser(UserOuterClass.UserInfo request, StreamObserver<UserOuterClass.ResponceMessage> responseObserver) {
        int id = request.getId();
        String username = request.getUsername();
        String password = request.getPassword();

        UserOuterClass.ResponceMessage.Builder response = UserOuterClass.ResponceMessage.newBuilder();
        if(regUser.addUser(new User(id,username,password))){
            //return success message
            response.setCode(210).setRspMessage("User added successfully");
        }
        else{
            //return failure message
            response.setCode(500).setRspMessage("Invalid username");
        }

        //wraps the response inside the response observer to send it
        //back to the client
        responseObserver.onNext(response.build());

        //closes the call
        responseObserver.onCompleted();
    }

}
