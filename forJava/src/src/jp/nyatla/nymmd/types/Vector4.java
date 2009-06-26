package jp.nyatla.nymmd.types;

import java.nio.ByteBuffer;

public class Vector4
{
	public double x, y, z, w;
	public void read(ByteBuffer i_buffer)
	{
		this.x=i_buffer.getFloat();
		this.y=i_buffer.getFloat();
		this.z=i_buffer.getFloat();
		this.w=i_buffer.getFloat();
		return;
	}		
	public void setValue(Vector4 v)
	{
		this.x=v.x;
		this.y=v.y;
		this.z=v.z;
		this.w=v.w;
		return;
	}	
	public void QuaternionSlerp(Vector4 pvec4Src1,Vector4 pvec4Src2, double fLerpValue )
	{

		// Qlerp
		double	qr = pvec4Src1.x * pvec4Src2.x + pvec4Src1.y * pvec4Src2.y + pvec4Src1.z * pvec4Src2.z + pvec4Src1.w * pvec4Src2.w;
		double	t0 = 1.0f - fLerpValue;

		if( qr < 0 )
		{
			this.x = pvec4Src1.x * t0 - pvec4Src2.x * fLerpValue;
			this.y = pvec4Src1.y * t0 - pvec4Src2.y * fLerpValue;
			this.z = pvec4Src1.z * t0 - pvec4Src2.z * fLerpValue;
			this.w = pvec4Src1.w * t0 - pvec4Src2.w * fLerpValue;
		}
		else
		{
			this.x = pvec4Src1.x * t0 + pvec4Src2.x * fLerpValue;
			this.y = pvec4Src1.y * t0 + pvec4Src2.y * fLerpValue;
			this.z = pvec4Src1.z * t0 + pvec4Src2.z * fLerpValue;
			this.w = pvec4Src1.w * t0 + pvec4Src2.w * fLerpValue;
		}
		QuaternionNormalize(this);
		return;
	}
	public void QuaternionNormalize(Vector4 pvec4Src)
	{
		final double fSqr =1.0 / Math.sqrt(( pvec4Src.x * pvec4Src.x + pvec4Src.y * pvec4Src.y + pvec4Src.z * pvec4Src.z + pvec4Src.w * pvec4Src.w));

		this.x =(pvec4Src.x * fSqr);
		this.y =(pvec4Src.y * fSqr);
		this.z =(pvec4Src.z * fSqr);
		this.w =(pvec4Src.w * fSqr);
	}
	public void QuaternionCreateAxis(Vector3 pvec3Axis, double fRotAngle )
	{
		if( Math.abs( fRotAngle ) < 0.0001f )
		{
			this.x = this.y = this.z = 0.0f;
			this.w = 1.0f;
		}
		else
		{
			fRotAngle *= 0.5f;
			double	fTemp = Math.sin(fRotAngle);

			this.x = pvec3Axis.x * fTemp;
			this.y = pvec3Axis.y * fTemp;
			this.z = pvec3Axis.z * fTemp;
			this.w = Math.cos( fRotAngle );
		}
		return;
	}
	public void QuaternionMultiply(Vector4 pvec4Src1,Vector4 pvec4Src2)
	{
		double	px, py, pz, pw;
		double	qx, qy, qz, qw;

		px = pvec4Src1.x; py = pvec4Src1.y; pz = pvec4Src1.z; pw = pvec4Src1.w;
		qx = pvec4Src2.x; qy = pvec4Src2.y; qz = pvec4Src2.z; qw = pvec4Src2.w;

		this.x = pw * qx + px * qw + py * qz - pz * qy;
		this.y = pw * qy - px * qz + py * qw + pz * qx;
		this.z = pw * qz + px * qy - py * qx + pz * qw;
		this.w = pw * qw - px * qx - py * qy - pz * qz;
	}
	public void QuaternionCreateEuler(Vector3 pvec3EulerAngle )
	{
		final double	xRadian = pvec3EulerAngle.x * 0.5;
		final double	yRadian = pvec3EulerAngle.y * 0.5;
		final double	zRadian = pvec3EulerAngle.z * 0.5;
		final double	sinX = Math.sin( xRadian );
		final double	cosX = Math.cos( xRadian );
		final double	sinY = Math.sin( yRadian );
		final double	cosY = Math.cos( yRadian );
		final double	sinZ = Math.sin( zRadian );
		final double	cosZ = Math.cos( zRadian );

		// XYZ
		this.x = sinX * cosY * cosZ - cosX * sinY * sinZ;
		this.y = cosX * sinY * cosZ + sinX * cosY * sinZ;
		this.z = cosX * cosY * sinZ - sinX * sinY * cosZ;
		this.w = cosX * cosY * cosZ + sinX * sinY * sinZ;
	}
	
}