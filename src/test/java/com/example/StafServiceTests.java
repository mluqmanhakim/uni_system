package com.example;
import java.util.List;


import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.StafModel;
import com.example.service.StafService;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StafServiceTests
{
	@Autowired
	StafService stafService;

	@Test
	public void testSelectAllStaf()
	{
		List<StafModel> listStaf = stafService.selectAllStaf(1);

		Assert.assertNotNull("Gagal = mahasiswa menghasilkan null", listStaf);
		Assert.assertTrue("Gagal - size students tidak lebih dari 1", listStaf.size() > 1);
	}

	@Test
	public void testSelectStaf()
	{
		StafModel staf = stafService.selectStaf("1000000005");
		
		Assert.assertNotNull("Gagal - mahasiswa menghasilkan null", staf);
		Assert.assertEquals("Gagal - nama students tidak sesuai", "Yanto", staf.getNama());
		Assert.assertEquals("Gagal - role mahasiswa tidak sesuai", "Dosen", staf.getRole());
	}

	@Test
	public void testCreateStaf()
	{
		StafModel staf = new StafModel("budi", "2000000002", 1, "Dosen", 1, null, null, null);

		// Cek apakah staf sudah ada
		Assert.assertNull("staf sudah ada", stafService.selectStaf(staf.getNik()));

		// Masukkan ke service
		stafService.addStaf(staf);
		
		// Cek apakah mahasiswa berhasil dimasukkan
		Assert.assertNotNull("Staf gagal dimasukkan", stafService.selectStaf(staf.getNik()));
	}

}