package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class HospitalViewModel extends AndroidViewModel
{
    private HospitalRepository mRepository;

    private LiveData<List<Patient>> mAllPatients;
    private LiveData<List<Nurse>> mAllNurses;
    private LiveData<List<Patient>> mPatientForNurse;

    public HospitalViewModel(Application application)
    {
        super(application);
        mRepository = new HospitalRepository(application);
        mAllPatients = mRepository.getAllPatients();
        mAllNurses = mRepository.getAllNurses();
    }

    LiveData<List<Patient>> getAllPatients() {return mAllPatients;}
    LiveData<List<Nurse>> getAllNurses() {return mAllNurses;}
    LiveData<List<Patient>> getAllPatientsForNurse(int nurseId)
    {
        mPatientForNurse = mRepository.getPatientsForNurse(nurseId);
        return mPatientForNurse;
    }
    Nurse getNurseByUsername(String username)
    {
        return mRepository.getNurseByUsername(username);
    }

    public void insertPatient(Patient patient) { mRepository.insertPatient(patient); }
    public void insertNurse(Nurse nurse) { mRepository.insertNurse(nurse); }
}