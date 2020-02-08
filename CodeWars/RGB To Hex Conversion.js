function rgb(r, g, b){
  r = validate(r);
  g = validate(g);
  b = validate(b);
  return r.toUpperCase().padStart(2, "0")+""+g.toUpperCase().padStart(2, "0")+""+b.toUpperCase().padStart(2, "0");;
}

function validate(val){
  if(val < 0 )
    val = 0;
  if(val > 255)
    val = 255;
  
  return Number(Math.abs(val)).toString(16);
}