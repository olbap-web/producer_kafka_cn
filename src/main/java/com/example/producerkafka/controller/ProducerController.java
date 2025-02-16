package com.example.producerkafka.controller;

import com.example.producerkafka.model.ApiRequest;
import com.example.producerkafka.model.SenalVital;
import com.example.producerkafka.model.SenalVitalBdd;
import com.example.producerkafka.service.KafkaService;
import com.example.producerkafka.service.MessageService;
// import com.example.producerkafka.service.SenalService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProducerController {

    @Autowired
    private KafkaService producerService;

    // @Autowired
    // private SenalService senalService;



    @PostMapping("send/")
    public void sendMessage(@RequestBody ApiRequest request) {

        String mensaje = "";

        String alerta  = "";

        List<SenalVital> senales = request.getSenalesVitales();

        for(SenalVital senal : senales){

            mensaje = "Paciente: "+request.getNombre()+" | Senal vital: "+senal.getNombre()+": "+senal.getValor();

            /**
             * Tenemos que hacer el insert de una nueva señal vital asociada al paciente
             * 
             * TENEMOS EL SIGUIENTE ERROR:
                * org.springframework.beans.factory.UnsatisfiedDependencyException: 
                * Error creating bean with name 'producerController': Unsatisfied dependency expressed through field 'senalService': 
                * Error creating bean with name 'senalServiceImpl': Unsatisfied dependency expressed through field 'SenalRepository': 
                * Error creating bean with name 'senalRepository' defined in com.example.producerkafka.repository.SenalRepository 
                *      defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: 
                * Not a managed type: class com.example.producerkafka.model.SenalVitalBdd
             * 
            */
            // SenalVitalBdd senalVital = new SenalVitalBdd(
            //     null,  
            //     senal.getNombre(),
            //     senal.getValor(),
            //     Long.parseLong(request.getId()) 
            // );
            // senalService.createSenal(senalVital);

            producerService.sendMessage(mensaje, 2);

            System.out.println(" : " + mensaje);

            if(senal.getNombre().equals("ritmo_cardiaco") && esNumeroValido(senal.getValor())){
                double valor = Double.parseDouble(senal.getValor());
                if(valor > 100){
                    alerta = " - Alerta: Paciente "+request.getNombre()+" con ritmo cardiaco mayor a 100 ("+senal.getValor()+")";
                    producerService.sendMessage(alerta, 1);
                    System.out.println(alerta);
                }
            }

            if(senal.getNombre().equals("temperatura") && esNumeroValido(senal.getValor())){
                double valor = Double.parseDouble(senal.getValor());
                if(valor > 37.5){
                    alerta = " - Alerta: Paciente "+request.getNombre()+" con fiebre ("+senal.getValor()+")";
                    producerService.sendMessage(alerta, 1);
                    System.out.println(alerta);

                }
            }
        }
    }

    public boolean esNumeroValido(String str) {
        try {
            Double.parseDouble(str);  
            return true; 
        } catch (NumberFormatException e) {
            return false;  
        }
    }

}