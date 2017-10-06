package com.example.rlard008.monitoringapp.codeandReason;

import java.util.ArrayList;

/**
 * Created by sudhakar on 3/31/17.
 */

//pojo class for Rejection Code and Reason
public class Rejection {
    public static ArrayList<CodeReason> getRejection()
    {
        ArrayList<CodeReason> arrayList=new ArrayList<>();
        arrayList.add(new CodeReason("1","MouldFlashes"));
        arrayList.add(new CodeReason("2","Incomplete_short-molded_pieces"));
        arrayList.add(new CodeReason("3","Shrink_mark_on_molded_pieces"));
        arrayList.add(new CodeReason("4","Discoloration_due_to_scorching_or_burning"));
        arrayList.add(new CodeReason("5","Poor_welds_flow_marksor_pleat_mark_in_molded_pieces"));
        arrayList.add(new CodeReason("6","Bubble_in_interior_of_molded_pieces"));
        arrayList.add(new CodeReason("7","Brittleness"));
        arrayList.add(new CodeReason("8","Piece_stick_in_cavity"));
        arrayList.add(new CodeReason("9","Pieces_wrap_after_removal_from_cavities"));
        arrayList.add(new CodeReason("10","Cloudy_surface_on_molding_or_cloudy_appearance_of_transparent_molding"));
        arrayList.add(new CodeReason("11","Mica_speaks_bubble_or_surface_lamination_of_molded_piece"));
        arrayList.add(new CodeReason("12","Molded_piece_have_odor"));
        arrayList.add(new CodeReason("13","Other"));
        return arrayList;
    }
}
