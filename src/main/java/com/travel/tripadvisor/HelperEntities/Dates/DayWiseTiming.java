package com.travel.tripadvisor.HelperEntities.Dates;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.time.DayOfWeek;

public class DayWiseTiming {


    class Timing {
        public Date openingTime;
        public Date closingTime;
    }

    public Map<DayOfWeek, Timing> timingList = null;

}
