# Se descarga data.zip

echo ""

echo "DESCARGANDO data.zip..."
echo ""
wget https://srvbioinf1.utalca.cl/~fduran/data.zip

# Se descarga scripts.zip
echo "DESCARGANDO scripts.zip..."
echo ""
wget https://srvbioinf1.utalca.cl/~fduran/scripts.zip

echo "DESCOMPRIMIENDO data.zip..."
echo ""
unzip data.zip

echo ""
echo "DESCOMPRINIENDO scripts.zip"
echo ""
unzip scripts.zip

mkdir data
mv Pan* data

mkdir resultados
src=data/Panguilemodetalle


for anio in 2010-2011 2011-2012 2012-2013 2014-2015a 2014-2015b ; do
	echo ""
	echo "CREANDO CARPETA resultados/${anio}..."
	echo ""
	mkdir resultados/$anio
	echo ${src}${anio}.csv
	file=${src}${anio}.csv
	echo "PROCESANDO ARCHIVOS..."
	echo ""

	cat ${file} | awk 'BEGIN{FS=";"; OFS=";"}{print $1, $7}' > resultados/$anio/temperatura_${anio}.csv
	cat ${file} | awk 'BEGIN{FS=";"; OFS=";"}{print $1, $6}' > resultados/$anio/humedad_${anio}.csv


	for i in  01 02 03 04 05 06 07 08 09 10 11 12; do
		for j in 0 1 2 3; do
			cat resultados/$anio/temperatura_${anio}.csv | grep "${i}-${j}" > resultados/$anio/temperatura_${anio}_${i}_${j}.csv
			cat resultados/$anio/humedad_${anio}.csv | grep "${i}-${j}" > resultados/$anio/humedad_${anio}_${i}_${j}.csv
		done
	done


	for i in  01 02 03 04 05 06 07 08 09 10 11 12; do
		cat resultados/$anio/temperatura_${anio}_${i}_0.csv resultados/$anio/temperatura_${anio}_${i}_1.csv resultados/$anio/temperatura_${anio}_${i}_2.csv resultados/$anio/temperatura_${anio}_${i}_3.csv > resultados/$anio/temperatura_${anio}_${i}.csv
		awk -v aux=$i ' BEGIN{OFS=";"} {suma+=$1; cant++} END {print aux, suma/cant}' resultados/$anio/temperatura_${anio}_${i}.csv > resultados/${anio}/temperatura_${anio}_prom_${i}.txt

		cat resultados/$anio/humedad_${anio}_${i}_0.csv resultados/$anio/humedad_${anio}_${i}_1.csv resultados/$anio/humedad_${anio}_${i}_2.csv resultados/$anio/humedad_${anio}_${i}_3.csv > resultados/$anio/humedad_${anio}_${i}.csv
		awk -v aux=$i 'BEGIN{OFS=";"} {suma+=$1; cant++} END {print aux, suma/cant}' resultados/$anio/humedad_${anio}_${i}.csv > resultados/$anio/humedad_${anio}_prom_${i}.txt

		rm resultados/$anio/temperatura_${anio}_${i}_*.csv
		rm resultados/$anio/humedad_${anio}_${i}_*.csv
	done

	cat resultados/$anio/temperatura_${anio}_prom_01.txt resultados/$anio/temperatura_${anio}_prom_02.txt resultados/$anio/temperatura_${anio}_prom_03.txt resultados/$anio/temperatura_${anio}_prom_04.txt resultados/$anio/temperatura_${anio}_prom_05.txt resultados/$anio/temperatura_${anio}_prom_06.txt resultados/$anio/temperatura_${anio}_prom_07.txt resultados/$anio/temperatura_${anio}_prom_08.txt resultados/$anio/temperatura_${anio}_prom_09.txt resultados/$anio/temperatura_${anio}_prom_10.txt resultados/$anio/temperatura_${anio}_prom_11.txt resultados/$anio/temperatura_${anio}_prom_12.txt > resultados/$anio/temperatura_${anio}_prom.txt 
	cat resultados/$anio/humedad_${anio}_prom_01.txt resultados/$anio/humedad_${anio}_prom_02.txt resultados/$anio/humedad_${anio}_prom_03.txt resultados/$anio/humedad_${anio}_prom_04.txt resultados/$anio/humedad_${anio}_prom_05.txt resultados/$anio/humedad_${anio}_prom_06.txt resultados/$anio/humedad_${anio}_prom_07.txt resultados/$anio/humedad_${anio}_prom_08.txt resultados/$anio/humedad_${anio}_prom_09.txt resultados/$anio/humedad_${anio}_prom_10.txt resultados/$anio/humedad_${anio}_prom_11.txt resultados/$anio/humedad_${anio}_prom_12.txt > resultados/$anio/humedad_${anio}_prom.txt 

	echo "GENERANDO GRAFICO TEMPERATURA DE ARCHIVO ${file}..."
	python -Wignore scripts/generateGraphic.py resultados/$anio graficoTemp resultados/$anio/temperatura_${anio}_prom.txt  "Meses" "Grados" "Promedio Temp Anio"

	echo "GENERANDO GRAFICO HUMEDAD DE ARCHIVO ${file}..."
    	python -Wignore scripts/generateGraphic.py resultados/$anio graficoHum resultados/$anio/humedad_${anio}_prom.txt "Meses" "Porcentaje" "Promedio Hum Anio"
done
