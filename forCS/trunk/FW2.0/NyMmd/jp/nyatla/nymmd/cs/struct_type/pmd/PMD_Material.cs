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


namespace jp.nyatla.nymmd.cs.struct_type.pmd
{
    public class PMD_Material : StructType
    {
        public MmdColor4 col4Diffuse = new MmdColor4();
        public float fShininess;
        public MmdColor3 col3Specular = new MmdColor3();
        public MmdColor3 col3Ambient = new MmdColor3();
        public int unknown;
        public int ulNumIndices;		// この材質に対応する頂点数
        public String szTextureFileName;	// テクスチャファイル名
        public void read(DataReader i_reader)
        {
            StructReader.read(this.col4Diffuse, i_reader);
            this.fShininess = i_reader.readFloat();
            StructReader.read(this.col3Specular, i_reader);
            StructReader.read(this.col3Ambient, i_reader);
            this.unknown = i_reader.readUnsignedShort();
            this.ulNumIndices = i_reader.readInt();
            this.szTextureFileName = i_reader.readAscii(20);
            return;
        }
    }
}
