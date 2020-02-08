function formatDuration (seconds) {
  // Complete this function
  return calcutaleTime(seconds);
}

function calcutaleTime(seconds){
  let min, hours, days, month, years;
  min = seconds/60;
  hours = min/60;
  days = hours/24;
  month = days/30; 
  years = month/365;
  if(years>0){
  console.log("anio");
            return calculateSec(seconds);

  } else {
    if(month>0){
      console.log("mes");

            return calculateSec(seconds);

    } else {
      if(days > 0){
        console.log("day");

            return calculateSec(seconds);

      } else{
        if(hours > 0){
          console.log("hour");

            return calculateSec(seconds);

        } else {
          if(min > 0){
            console.log("min");

            return calculateSec(seconds);

          } else{
            console.log("sec");

            return calculateSec(seconds);
          }
        }
      }
    }
  }
  
  
}

function calculateSec(seconds){
  if (seconds < 2)
    return seconds+" second";
  else
    return seconds+" seconds";
}

function calculateMin(seconds){
  if (seconds < 2)
    return seconds+" second";
  else
    return seconds+" seconds";
}

function calculateHour(seconds){
  if (seconds < 2)
    return seconds+" second";
  else
    return seconds+" seconds";
}

function calculateDay(seconds){
  if (seconds < 2)
    return seconds+" second";
  else
    return seconds+" seconds";
}

function calculateMonth(seconds){
  if (seconds < 2)
    return seconds+" second";
  else
    return seconds+" seconds";
}

function calculateYear(seconds){
  if (seconds < 2)
    return seconds+" second";
  else
    return seconds+" seconds";
}