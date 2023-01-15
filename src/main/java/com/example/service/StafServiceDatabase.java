package com.example.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.dao.StafMapper;
import com.example.model.GajiModel;
import com.example.model.GajiPerBulanModel;
import com.example.model.KehadiranDosenModel;
import com.example.model.StafModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
public class StafServiceDatabase implements StafService {
	@Autowired
	private StafMapper stafMapper;

	// staf pendukung hanya dihitung pada tahun 2016 sampai sistem berjalan,
	// dosen gaji dihitung hanya jika ada kehadiran dosennya,
	@Override
	public StafModel selectStaf(String nik) {

		// TODO Auto-generated method stub
		StafModel staf = stafMapper.selectStaf(nik);
		if (staf != null) {
			staf.setGaji(new ArrayList<GajiPerBulanModel>());
			Date date = new Date();

			int batasBulan = date.getMonth();
			int batasTahun = date.getYear();

			if (staf.getRole().equalsIgnoreCase("Dosen")) {

				staf.setKehadiran(stafMapper.selectKehadiran(nik));

				List<Integer> sks = new ArrayList<Integer>();
				List<KehadiranDosenModel> kehadiran = staf.getKehadiran();
				if (kehadiran.size() != 0) {
					// int banyakTahun =
					// Math.abs(kehadiran.get(0).getTanggal().getYear() -
					// kehadiran.get(kehadiran.size()-1).getTanggal().getYear());
					String[] namaBulan = { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus",
							"September", "Oktober", "November", "Desember" };
					// int banyakTahun = Math.abs(kehadiran.get(kehadiran.size()
					// -
					// 1).getTanggal().getYear()
					// - kehadiran.get(0).getTanggal().getYear()) + 1;

					// Collections.max(kehadiran.g);
					int tahunTerbesar = 116;
					int tahunTerkecil = 116;
					for (int i = 0; i < kehadiran.size(); i++) {
						if (kehadiran.get(i).getTanggal().getYear() > tahunTerbesar) {
							tahunTerbesar = kehadiran.get(i).getTanggal().getYear();
						}
						if (kehadiran.get(i).getTanggal().getYear() < tahunTerkecil) {
							tahunTerkecil = kehadiran.get(i).getTanggal().getYear();
						}

					}
					int banyakTahun = tahunTerbesar - tahunTerkecil + 1;
					// mulai tahun terkecil
					int tahun = tahunTerkecil;

					for (int j = 0; j < banyakTahun; j++) {
						for (int i = 0; i < 12; i++) {
							sks.add(0);
							for (int ii = 0; ii < kehadiran.size(); ii++) {

								if (kehadiran.get(ii).getTanggal().getMonth() == i
										&& kehadiran.get(ii).getTanggal().getYear() == tahun) {

									sks.set(i, sks.get(i) + kehadiran.get(ii).getJadwal().getSks());
								}
							}

							// jika batas bulan sudah lewat di tahun terakhir
							if (j == banyakTahun - 1 && i > batasBulan) {

								continue;

							}
							staf.getGaji().add(new GajiPerBulanModel(1900 + tahun, namaBulan[i],
									(sks.get(i) * 50000) + staf.getGajiStandar().getNominal()));
						}
						tahun++;
					}
				}
				// jika dosen tapi daftar kehadiran tidak ada
				else {
					String[] namaBulan = { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus",
							"September", "Oktober", "November", "Desember" };

					for (int j = 116; j <= batasTahun; j++) {
						for (int i = 0; i < 12; i++) {
							if (!(j == batasTahun && i > batasBulan)) {
								staf.getGaji().add(new GajiPerBulanModel(1990 + j, namaBulan[i],
										staf.getGajiStandar().getNominal()));
							}

						}
					}

				}
			}

			// jika bukan dosen
			else {
				String[] namaBulan = { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus",
						"September", "Oktober", "November", "Desember" };

				for (int j = 116; j <= batasTahun; j++) {
					for (int i = 0; i < 12; i++) {
						if (!(j == batasTahun && i > batasBulan)) {
							staf.getGaji().add(
									new GajiPerBulanModel(1900 + j, namaBulan[i], staf.getGajiStandar().getNominal()));
						}

					}
				}

			}
		}
		return staf;
	}

	@Override
	public void addStaf(StafModel staf) {
		log.info("add staf");
		stafMapper.addStaf(staf);
	}

	@Override
	public List<StafModel> selectAllStaf(int idProdi) {
		log.info("staf prodi" + idProdi);
		return stafMapper.selectAllStaf(idProdi);
	}

	@Override
	public StafModel selectStafDenganIdKelas(int idKelas) {
		return stafMapper.selectStafDenganIdKelas(idKelas);
	}

	@Override
	public void updateStaf(StafModel staf) {
		log.info("staf " + staf.getNik() + " updated");
		stafMapper.updateStaf(staf);
	}

	@Override
	public List<StafModel> selectAllStafWithGaji(int idProdi, int bulan, int tahun) {
		// TODO Auto-generated method stub
		String[] namaBulan = { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September",
				"Oktober", "November", "Desember" };

		List<StafModel> kumpulanStaf = stafMapper.selectAllStafWithGaji(idProdi);

		for (int i = 0; i < kumpulanStaf.size(); i++) {

			int bulanAsli = bulan + 1;
			int tahunAsli = tahun + 1900;
			// System.out.println(bulanAsli);
			// System.out.println(tahunAsli);
			List<KehadiranDosenModel> kehadiran = stafMapper
					.selectKehadiranDenganBatasWaktu(kumpulanStaf.get(i).getNik(), bulanAsli, tahunAsli);

			// System.out.println(kumpulanStaf.get(i).getNik());
			// System.out.println(kumpulanStaf.get(i).getNama());
			// System.out.println(kehadiran.size());
			if (kumpulanStaf.get(i).getRole().equalsIgnoreCase("Dosen") && kehadiran.size() != 0) {
				kumpulanStaf.get(i).setKehadiran(kehadiran);
				int sks = 0;
				for (int ii = 0; ii < kumpulanStaf.get(i).getKehadiran().size(); ii++) {
					sks = sks + kumpulanStaf.get(i).getKehadiran().get(ii).getJadwal().getSks();

					// System.out.println(sks);

				}

				kumpulanStaf.get(i).setGaji(new ArrayList<GajiPerBulanModel>());
				// System.out.println(kumpulanStaf.get(i).getNama());
				kumpulanStaf.get(i).getGaji().add(new GajiPerBulanModel(1990 + tahun, namaBulan[bulan],
						(sks * 50000) + kumpulanStaf.get(i).getGajiStandar().getNominal()));

			} else {
				// System.out.println(kumpulanStaf.get(i).getNama());

				kumpulanStaf.get(i).setGaji(new ArrayList<GajiPerBulanModel>());

				kumpulanStaf.get(i).getGaji().add(new GajiPerBulanModel(1900 + tahun, namaBulan[bulan],
						kumpulanStaf.get(i).getGajiStandar().getNominal()));

			}

		}

		return kumpulanStaf;
	}

	@Override
	public List<StafModel> selectHanyaDosen(int idProdi) {
		// TODO Auto-generated method stub
		return stafMapper.selectHanyaDosen(idProdi);
	}

	@Override
	public void deleteStaf(String nik) {
		// TODO Auto-generated method stub
		stafMapper.deleteStaf(nik);
	}

	@Override
	public List<Integer> selectAllProdi(int idProdi) {
		// TODO Auto-generated method stub
		int idUniv = stafMapper.selectUniv(idProdi);

		return stafMapper.selectAllProdi(idUniv);
	}

	@Override
	public List<Integer> selectAllProdiDiFakultas(int idProdi) {
		// TODO Auto-generated method stub
		int idFakultas = stafMapper.selectFakultas(idProdi);

		return stafMapper.selectAllProdiDiFakultas(idFakultas);
	}

	@Override
	public String selectNamaUniv(int idProdi) {
		// TODO Auto-generated method stub
		int idUniv = stafMapper.selectUniv(idProdi);

		return stafMapper.selectNamaUniv(idUniv);
	}

	@Override
	public String selectFakultas(int idProdi) {
		// TODO Auto-generated method stub

		int idFakultas = stafMapper.selectFakultas(idProdi);

		return stafMapper.selectNamaFakultas(idFakultas);
	}

	@Override
	public String selectNamaProdi(int idProdi) {
		// TODO Auto-generated method stub
		return stafMapper.selectNamaProdi(idProdi);
	}

}
