package ar.com.ada.api.cash.models.responses;

import java.util.ArrayList;
import java.util.List;

import ar.com.ada.api.cash.entities.Loan;

public class InfoLoans {

    public List<Loan> items = new ArrayList<>();

    public PagingControl paging = new PagingControl();
}
