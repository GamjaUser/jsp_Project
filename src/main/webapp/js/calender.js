function changeDate(deltaYear, deltaMonth) {
        var yearInput = document.getElementById("year");
        var monthInput = document.getElementById("month");

        var year = parseInt(yearInput.value) + deltaYear;
        var month = parseInt(monthInput.value) + deltaMonth;

        if (month < 1) {
            month = 12;
            year--;
        } else if (month > 12) {
            month = 1;
            year++;
        }

        yearInput.value = year;
        monthInput.value = month;
        document.getElementById("dateForm").submit();
    }



    