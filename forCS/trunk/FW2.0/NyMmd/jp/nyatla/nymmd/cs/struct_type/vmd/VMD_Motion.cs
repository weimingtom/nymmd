﻿/* 
 * PROJECT: NyMmd for C#
 * --------------------------------------------------------------------------------
 * The MMD for C# is C# version MMD Motion player class library.
 * NyMmd is modules which removed the ARToolKit origin codes from ARTK_MMD,
 * and was ported to C#. 
 *
 * This is based on the ARTK_MMD v0.1 by PY.
 * http://ppyy.if.land.to/artk_mmd.html
 * py1024<at>gmail.com
 * http://www.nicovideo.jp/watch/sm7398691
 *
 * 
 * The MIT License
 * Copyright (C)2008-2012 nyatla
 * nyatla39<at>gmail.com
 * http://nyatla.jp
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 */
using System;
using System.Collections.Generic;
using System.Text;
using jp.nyatla.nymmd.cs.types;


namespace jp.nyatla.nymmd.cs.struct_type.vmd
{
    class VMD_Motion : StructType
    {
        public String szBoneName;	// ボーン名
        public long ulFrameNo;		// フレーム番号

        public MmdVector3 vec3Position = new MmdVector3();// 位置
        public MmdVector4 vec4Rotate = new MmdVector4();  // 回転(クォータニオン)

        public int[] cInterpolation1 = new int[16];	// 補間情報
        public int[] cInterpolation2 = new int[16];
        public int[] cInterpolation3 = new int[16];
        public int[] cInterpolation4 = new int[16];

        public void read(DataReader i_reader)
        {
            int i;
            //szName
            this.szBoneName = i_reader.readAscii(15);
            this.ulFrameNo = i_reader.readInt();
            StructReader.read(this.vec3Position, i_reader);
            StructReader.read(this.vec4Rotate, i_reader);
            for (i = 0; i < 16; i++)
            {
                this.cInterpolation1[i] = i_reader.readByte();
            }
            for (i = 0; i < 16; i++)
            {
                this.cInterpolation2[i] = i_reader.readByte();
            }
            for (i = 0; i < 16; i++)
            {
                this.cInterpolation3[i] = i_reader.readByte();
            }
            for (i = 0; i < 16; i++)
            {
                this.cInterpolation4[i] = i_reader.readByte();
            }
            return;
        }
    }
}
