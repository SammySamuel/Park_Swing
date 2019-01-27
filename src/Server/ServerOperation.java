package Server;

// lista metod uzywanych w serwerze
public enum ServerOperation {
    disconnect,
    addPracownik, getPracownik, getSPracownik, howManyPracownik, getPracownikToList, removeUserFromBase,
    addAttraction, getAttraction, getAttractionToList,
    getRaport, addRaport,getUnimplementedRaport,updateStatusRaport,getReportRaport,takeRaport,getAllRaportStatus,getAllRaport,
    addPlan,getPlan,getOneDayPlanList,getWeekPlanList,
    getTypPracownika,
    getTypAwarii,
    getStanowisko,
}
