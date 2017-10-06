package com.example.rlard008.monitoringapp.codeandReason;

import java.util.ArrayList;

/**
 * Created by sudhakar on 3/31/17.
 */

//Pojo class for Downtime code and reason
public class DownTime {

    public static ArrayList<CodeReason> getDownTime()
    {
        ArrayList<CodeReason> arrayList=new ArrayList<>();
        arrayList.add(new CodeReason("1","Powerfailure"));
        arrayList.add(new CodeReason("2","OperatorAbsenteeism"));
        arrayList.add(new CodeReason("3","Moldchange"));
        arrayList.add(new CodeReason("4","MoldMaintenance"));
        arrayList.add(new CodeReason("5","Machinestartup"));
        arrayList.add(new CodeReason("6","Noproductionplan"));
        arrayList.add(new CodeReason("7","RawMaterialshortage"));
        arrayList.add(new CodeReason("8","Colorchange"));
        arrayList.add(new CodeReason("9","ScheduledMaintenance"));
        arrayList.add(new CodeReason("10","Preventivemaintenance"));
        arrayList.add(new CodeReason("11","Trialofmould"));
        arrayList.add(new CodeReason("12","Color_shade_problem"));
        arrayList.add(new CodeReason("13","Machine_Completely_Dead"));
        arrayList.add(new CodeReason("14","Main_Motor_Trip"));
        arrayList.add(new CodeReason("15","Product_stickup_in_mould"));
        arrayList.add(new CodeReason("16","Hydraulic_leakage"));
        arrayList.add(new CodeReason("17","Pump_pressure_not_developing"));
        arrayList.add(new CodeReason("18","Refill_does_not_functioning"));
        arrayList.add(new CodeReason("19","Temperature_indicates_erratic"));
        arrayList.add(new CodeReason("20","Barrel_overheating_in_one_or_more_zone"));
        arrayList.add(new CodeReason("21","Suck_back_not_working"));
        arrayList.add(new CodeReason("22","Mould_Insert_change"));
        arrayList.add(new CodeReason("23","Heater_circuit_breaker_trips"));
        arrayList.add(new CodeReason("24","Injection_not_functioning"));
        arrayList.add(new CodeReason("25","Core_Pulling_not_working"));
        arrayList.add(new CodeReason("26","Hopper_Dryer_material_not_loading"));
        arrayList.add(new CodeReason("27","Mould_under_maintenance_when_Machine_is_On"));
        arrayList.add(new CodeReason("28","Mold_cooling_is_not_proper"));
        arrayList.add(new CodeReason("29","Platens_fail_to_close_when_selected"));
        arrayList.add(new CodeReason("30","Pump_noisy"));
        arrayList.add(new CodeReason("31","Cooling_tower_not_working"));
        arrayList.add(new CodeReason("32","Compressor_not_working"));
        arrayList.add(new CodeReason("33","Crane_failure"));
        arrayList.add(new CodeReason("34","Mould_opening_fails(after_closing_&_tonnage)when_selected"));
        arrayList.add(new CodeReason("35","Mould_closes_but_no_tonnage_build_up"));
        arrayList.add(new CodeReason("36","Oil_Temp_high"));
        arrayList.add(new CodeReason("37","Screw_and_Barrel_Wear_out"));
        arrayList.add(new CodeReason("38","Barrel_head_leakage"));
        arrayList.add(new CodeReason("39","Shutter_not_working"));
        arrayList.add(new CodeReason("40","Hyd._Ejector_not_functioning"));
        arrayList.add(new CodeReason("41","Other"));
        return arrayList;

    }
}
