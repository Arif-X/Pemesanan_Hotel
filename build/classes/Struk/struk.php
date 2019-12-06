<?php
	include "config/koneksi.php";
	$struk = $_GET['id-pemesanan'];
?>
<!DOCTYPE html>
<html>
<head>
	<title>Struk</title>
</head>
<body>
	<form method="post">
	<table border="1" align="center">
		<tr>
			<td>
				<div class="mainutama" style="width: 500px;">
					<table align="center"> 
						<tr>
       						<td width="93%" valign="bottom">&nbsp;STRUK PEMESANAN</td>
						</tr>
					</table>					
					<hr>
					<table width="100%">
						<?php 
						$total = 0;
						$kembali = 0;
						$bayar =0 ;
						$no = 0;
						$sql = "SELECT * FROM pemesanan where id_pemesanan = $struk";
						$qury = mysqli_query($con,$sql);
						
						while ($data = mysqli_fetch_array($qury)) {							
							?>
							<tr>
								<td>ID Pemesanan</td>
								<td>: <?php echo @$data['id_pemesanan'] ?></td>
							</tr>
							<tr>
								<td>Pemesan</td>
								<td>: <?php echo @$data['email_pemesan'] ?></td>
							</tr>
							<tr>
								<td>ID Hotel</td>
								<td>: <?php echo @$data['id_hotel'] ?></td>
							</tr>
							<tr>
								<td>Jenis Kamar</td>
								<td>: <?php echo @$data['jenis_kamar'] ?></td>
							</tr>
							<tr>
								<td>Tanggal Check In</td>
								<td>: <?php echo @$data['tgl_check_in'] ?></td>
							</tr>
							<tr>
								<td>Tanggal Check Out</td>
								<td>: <?php echo @$data['tgl_check_out'] ?></td>
							</tr>
							<tr>
								<td>Harga Permalam</td>
								<td>: <?php echo @$data['harga_permalam'] ?></td>
							</tr>	
							<tr>
								<td>Total</td>
								<td>: <?php echo @$data['harga_total'] ?></td>
							</tr>			
							<tr>
								<td>Link</td>
								<td>: <?php echo "localhost/struk/struk?id-pemesanan=".$data['id_pemesanan'] ?></td>
							</tr>			
							<?php
						}

						 ?>
					</table>
					<hr>
			    	<table align="center">			      		
						<p align="center">Simpan Struk Ini Sebagai Bukti Pemesanan *</p>
						<tr>
							<td>&copy; <?php echo date('Y'); ?> Pemesanan Hotel Java</td>
			      		</tr>
			    	</table>
				</div>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>